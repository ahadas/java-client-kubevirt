/*
 * KubeVirt API
 * This is KubeVirt API an add-on for Kubernetes.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: kubevirt-dev@googlegroups.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package kubevirt.io;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * TCPSocketAction describes an action based on opening a socket
 */
@ApiModel(description = "TCPSocketAction describes an action based on opening a socket")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-10T14:44:51.030+02:00")
public class V1TCPSocketAction {
  @SerializedName("host")
  private String host = null;

  public V1TCPSocketAction host(String host) {
    this.host = host;
    return this;
  }

   /**
   * Optional: Host name to connect to, defaults to the pod IP.
   * @return host
  **/
  @ApiModelProperty(value = "Optional: Host name to connect to, defaults to the pod IP.")
  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1TCPSocketAction v1TCPSocketAction = (V1TCPSocketAction) o;
    return Objects.equals(this.host, v1TCPSocketAction.host);
  }

  @Override
  public int hashCode() {
    return Objects.hash(host);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1TCPSocketAction {\n");
    
    sb.append("    host: ").append(toIndentedString(host)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
