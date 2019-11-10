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
 * Represents a docker image with an embedded disk.
 */
@ApiModel(description = "Represents a docker image with an embedded disk.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-11-10T14:44:51.030+02:00")
public class V1ContainerDiskSource {
  @SerializedName("image")
  private String image = null;

  @SerializedName("imagePullPolicy")
  private String imagePullPolicy = null;

  @SerializedName("imagePullSecret")
  private String imagePullSecret = null;

  @SerializedName("path")
  private String path = null;

  public V1ContainerDiskSource image(String image) {
    this.image = image;
    return this;
  }

   /**
   * Image is the name of the image with the embedded disk.
   * @return image
  **/
  @ApiModelProperty(required = true, value = "Image is the name of the image with the embedded disk.")
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public V1ContainerDiskSource imagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
    return this;
  }

   /**
   * Image pull policy. One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise. Cannot be updated. More info: https://kubernetes.io/docs/concepts/containers/images#updating-images +optional
   * @return imagePullPolicy
  **/
  @ApiModelProperty(value = "Image pull policy. One of Always, Never, IfNotPresent. Defaults to Always if :latest tag is specified, or IfNotPresent otherwise. Cannot be updated. More info: https://kubernetes.io/docs/concepts/containers/images#updating-images +optional")
  public String getImagePullPolicy() {
    return imagePullPolicy;
  }

  public void setImagePullPolicy(String imagePullPolicy) {
    this.imagePullPolicy = imagePullPolicy;
  }

  public V1ContainerDiskSource imagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
    return this;
  }

   /**
   * ImagePullSecret is the name of the Docker registry secret required to pull the image. The secret must already exist.
   * @return imagePullSecret
  **/
  @ApiModelProperty(value = "ImagePullSecret is the name of the Docker registry secret required to pull the image. The secret must already exist.")
  public String getImagePullSecret() {
    return imagePullSecret;
  }

  public void setImagePullSecret(String imagePullSecret) {
    this.imagePullSecret = imagePullSecret;
  }

  public V1ContainerDiskSource path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Path defines the path to disk file in the container
   * @return path
  **/
  @ApiModelProperty(value = "Path defines the path to disk file in the container")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V1ContainerDiskSource v1ContainerDiskSource = (V1ContainerDiskSource) o;
    return Objects.equals(this.image, v1ContainerDiskSource.image) &&
        Objects.equals(this.imagePullPolicy, v1ContainerDiskSource.imagePullPolicy) &&
        Objects.equals(this.imagePullSecret, v1ContainerDiskSource.imagePullSecret) &&
        Objects.equals(this.path, v1ContainerDiskSource.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(image, imagePullPolicy, imagePullSecret, path);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V1ContainerDiskSource {\n");
    
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    imagePullPolicy: ").append(toIndentedString(imagePullPolicy)).append("\n");
    sb.append("    imagePullSecret: ").append(toIndentedString(imagePullSecret)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
