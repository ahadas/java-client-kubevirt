package test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.kubernetes.client.util.Watch;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1NodeList;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import io.kubernetes.client.apis.CustomObjectsApi;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

public class Main {

    public static void main(String[] args) throws IOException, ApiException  {
	System.out.println("start");

	// file path to your KubeConfig
	String kubeConfigPath = "/home/ahadas/.kube/.kubeconfig";

	// loading the out-of-cluster config, a kubeconfig from file-system
	ApiClient client =
	    ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
	Configuration.setDefaultApiClient(client);
	
	CoreV1Api api = new CoreV1Api();
	V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null);
	System.out.println("Pods:");
	for (V1Pod item : list.getItems()) {
            System.out.println(item.getMetadata().getName());
        }

	/*System.out.println("Nodes:");
	V1NodeList nodes = api.listNodesForAllNamepaces(null, null, null, null, null, null, null, null);
	for (V1Node node : nodes.getItems()) {
	    
	}*/

	System.out.println("\nVirtual Machines:");
	CustomObjectsApi apiInstance = new CustomObjectsApi();
	String group = "kubevirt.io"; // String | The custom resource's group name
	String version = "v1alpha3"; // String | The custom resource's version
	String plural = "virtualmachines"; // String | The custom resource's plural name. For TPRs this would be lowercase plural kind.
	String pretty = "true"; // String | If 'true', then the output is pretty printed.
	String fieldSelector = null; //"fieldSelector_example"; // String | A selector to restrict the list of returned objects by their fields. Defaults to everything.
	String labelSelector = null; //"labelSelector_example"; // String | A selector to restrict the list of returned objects by their labels. Defaults to everything.
	String resourceVersion = null;//"263558"; // String | When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
	Integer timeoutSeconds = 0; // Integer | Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
	Boolean watch = false; // Boolean | Watch for changes to the described resources and return them as a stream of add, update, and remove notifications.
	String namespace = "default";
	System.out.println("watch: " + watch);
	client.getHttpClient().setReadTimeout(0, TimeUnit.SECONDS); // infinite timeout

	/*	try {
	    Map result = (Map) apiInstance.listNamespacedCustomObject(group, version, namespace, plural, pretty, fieldSelector, labelSelector, resourceVersion, timeoutSeconds, watch);
	    System.out.println(result.getClass().getName());
    	    List items = (List) result.get("items");
	    System.out.println(items.get(0).getClass().getName());
	    Map item = (Map) items.get(0);
	    System.out.println(item);
	} catch (ApiException e) {
	    System.err.println("Exception when calling CustomObjectsApi#listClusterCustomObject");
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	    }*/

	Configuration.setDefaultApiClient(client);

	//l = api.listNode(null, null, null, null, 0, rv, 3, false);
	//System.out.println(l);

	namespace = "";
	Watch<LinkedTreeMap> watch2 =
	    Watch.createWatch(
			      client,
			      //apiInstance.listNamespacedCustomObjectCall(group, version, namespace, plural, pretty, null, null, null, null, Boolean.TRUE, null, null),
			      apiInstance.listClusterCustomObjectCall(group, version, plural, pretty, null, null, null, null, Boolean.TRUE, null, null),
			      new TypeToken<Watch.Response<LinkedTreeMap>>() {}.getType());
	try {
	    for (Watch.Response<LinkedTreeMap> item : watch2) {
		System.out.printf("%s : %s%n", item.type, item.object);
	    }
	} finally {
	    watch2.close();
	}
    }
}