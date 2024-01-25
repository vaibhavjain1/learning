import com.datadog.api.client.ApiClient;
import com.datadog.api.client.ApiException;
import com.datadog.api.client.v1.api.EventsApi;
import com.datadog.api.client.v1.model.EventCreateRequest;
import com.datadog.api.client.v1.model.EventCreateResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Example
{
    public static void main(String arg[]){
        testDataDog();
    }
    public static void testDataDog() {
        ApiClient defaultClient = new ApiClient();
        defaultClient.setApiKey("");
        EventsApi apiInstance = new EventsApi(defaultClient);
        List<String> AppName = new ArrayList<>();
        Collections.addAll(AppName, "appName1", "appName2", "appName3", "appName4", "appName5");
        List<String> AppCycle = new ArrayList<String>();
        Collections.addAll(AppCycle, "AppCycle1", "AppCycle2", "AppCycle3", "AppCycle4", "AppCycle5");
        List<String> ProcessName = new ArrayList<String>();
        Collections.addAll(ProcessName, "ProcessName1", "ProcessName2", "ProcessName3", "ProcessName4", "ProcessName5");

        for(int i=0; i<1; i++) {
            List<String> tagList = new ArrayList<String>();
            //tagList.add("source:Tidemark Systems");
            tagList.add("App Name: " + AppName.get(i));
            tagList.add("App Cycle: " + AppCycle.get(i));
            tagList.add("Process Name: " + ProcessName.get(i));

			/*
			 * EventCreateRequest body1 = new EventCreateRequest() .title("Title")
			 * .tags(tagList) .sourceTypeName("java"); body1.setSourceTypeName("java");
			 */
            EventCreateRequest body =
                    new EventCreateRequest()
                        .title("Title")
                        .text("A text message.")
                        .tags(Collections.singletonList("test:ExamplePostaneventreturnsOKresponse"))
                        .sourceTypeName("Xyz");
            

            try {
                EventCreateResponse result = apiInstance.createEvent(body);
                System.out.println(result);
            } catch (ApiException e) {
                System.err.println("Exception when calling EventsApi#createEvent");
                System.err.println("Status code: " + e.getCode());
                System.err.println("Reason: " + e.getResponseBody());
                System.err.println("Response headers: " + e.getResponseHeaders());
                e.printStackTrace();
            }
        }
    }
}
