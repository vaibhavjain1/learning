import com.datadog.api.client.ApiClient;
import com.datadog.api.client.ApiException;
import com.datadog.api.client.v1.api.EventsApi;
import com.datadog.api.client.v1.model.Event;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.*;

public class FetchEvents {
    static boolean append = true;
    public static void main(String[] args) {
        ApiClient defaultClient = new ApiClient();

        HashMap<String, String> secrets = new HashMap<String, String>();
        secrets.put("apiKeyAuth", "");
        secrets.put("appKeyAuth", "");
        defaultClient.configureApiKeys(secrets);
        EventsApi apiInstance = new EventsApi(defaultClient);

        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Stanford");

        //Prepare data to be written as an Object[]
        Map<String, Object[]> data = new LinkedHashMap<>();
        data.put("0", new Object[]{"sno", "pageselections", "processcyclename", "processname", "processingtimemillis", "slicename", "step", "timestamp", "username", "day_xlsx_est"});

        EventsApi.ListEventsOptionalParameters list = new EventsApi.ListEventsOptionalParameters();
        list.tags("tenant:veoliahq");

        int sno = 1;

        ZonedDateTime zone = ZonedDateTime.parse("2023-12-18T00:00:00+00:00[UTC]");
        try {
            while (zone.getYear() == 2023) {
                zone = zone.plusMinutes(5);

                List<Event> events = apiInstance.listEvents(zone.toInstant().getEpochSecond(), zone.plusMinutes(5).toInstant().getEpochSecond(), list).getEvents();
                System.out.println("Events Size for zone: " + zone + " is :" + events.size());

                for (Event event : events) {
                    Long timeStamp = event.getDateHappened();
                    SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY HH:mm");
                    format.setTimeZone(TimeZone.getTimeZone("UTC"));
                    String day_xlsx_est = format.format(new Date(timeStamp * 1000));

                    List<String> tags = event.getTags();
                    String pageselections = "";
                    String processcyclename = "";
                    String processname = "";
                    String processingtimemillis = "";
                    String slicename = "";
                    String step = "";
                    String username = "";
                    for (String tag : tags) {
                        String[] split = tag.split(":");
                        if (split.length == 1)
                            continue;
                        switch (split[0]) {
                            case ("pageselections"):
                                pageselections = split[1];
                                break;
                            case ("processcyclename"):
                                processcyclename = split[1];
                                break;
                            case ("processname"):
                                processname = split[1];
                                break;
                            case ("processingtimemillis"):
                                processingtimemillis = split[1];
                                break;
                            case ("slicename"):
                                slicename = split[1];
                                break;
                            case ("step"):
                                step = split[1];
                                break;
                            case ("username"):
                                username = split[1];
                                break;
                        }
                    }

                    if(username.length()>0 && !step.equalsIgnoreCase("not_set"))
                        data.put(String.valueOf(sno), new Object[]{sno, pageselections, processcyclename, processname, processingtimemillis, slicename, step, timeStamp, username, day_xlsx_est});

                    sno++;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
                else if (obj instanceof Long)
                    cell.setCellValue((Long) obj);
            }
        }

        //Write the workbook in file system
        try {
            FileOutputStream out = new FileOutputStream("d:/demo.xlsx");
            workbook.write(out);
            out.close();
            System.out.println("demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
