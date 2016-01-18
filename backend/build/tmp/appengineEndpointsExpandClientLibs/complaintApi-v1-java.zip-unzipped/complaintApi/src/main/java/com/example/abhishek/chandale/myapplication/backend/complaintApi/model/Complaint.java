/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-01-08 17:48:37 UTC)
 * on 2016-01-18 at 11:06:23 UTC 
 * Modify at your own risk.
 */

package com.example.abhishek.chandale.myapplication.backend.complaintApi.model;

/**
 * Model definition for Complaint.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the complaintApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Complaint extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String city;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String complaintAddress;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String complaintMessage;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String date;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String email;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String image;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double lat;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double lon;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String mobile;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String name;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getCity() {
    return city;
  }

  /**
   * @param city city or {@code null} for none
   */
  public Complaint setCity(java.lang.String city) {
    this.city = city;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getComplaintAddress() {
    return complaintAddress;
  }

  /**
   * @param complaintAddress complaintAddress or {@code null} for none
   */
  public Complaint setComplaintAddress(java.lang.String complaintAddress) {
    this.complaintAddress = complaintAddress;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getComplaintMessage() {
    return complaintMessage;
  }

  /**
   * @param complaintMessage complaintMessage or {@code null} for none
   */
  public Complaint setComplaintMessage(java.lang.String complaintMessage) {
    this.complaintMessage = complaintMessage;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDate() {
    return date;
  }

  /**
   * @param date date or {@code null} for none
   */
  public Complaint setDate(java.lang.String date) {
    this.date = date;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getEmail() {
    return email;
  }

  /**
   * @param email email or {@code null} for none
   */
  public Complaint setEmail(java.lang.String email) {
    this.email = email;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Complaint setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @see #decodeImage()
   * @return value or {@code null} for none
   */
  public java.lang.String getImage() {
    return image;
  }

  /**

   * @see #getImage()
   * @return Base64 decoded value or {@code null} for none
   *
   * @since 1.14
   */
  public byte[] decodeImage() {
    return com.google.api.client.util.Base64.decodeBase64(image);
  }

  /**
   * @see #encodeImage()
   * @param image image or {@code null} for none
   */
  public Complaint setImage(java.lang.String image) {
    this.image = image;
    return this;
  }

  /**

   * @see #setImage()
   *
   * <p>
   * The value is encoded Base64 or {@code null} for none.
   * </p>
   *
   * @since 1.14
   */
  public Complaint encodeImage(byte[] image) {
    this.image = com.google.api.client.util.Base64.encodeBase64URLSafeString(image);
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLat() {
    return lat;
  }

  /**
   * @param lat lat or {@code null} for none
   */
  public Complaint setLat(java.lang.Double lat) {
    this.lat = lat;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getLon() {
    return lon;
  }

  /**
   * @param lon lon or {@code null} for none
   */
  public Complaint setLon(java.lang.Double lon) {
    this.lon = lon;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMobile() {
    return mobile;
  }

  /**
   * @param mobile mobile or {@code null} for none
   */
  public Complaint setMobile(java.lang.String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * @param name name or {@code null} for none
   */
  public Complaint setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  @Override
  public Complaint set(String fieldName, Object value) {
    return (Complaint) super.set(fieldName, value);
  }

  @Override
  public Complaint clone() {
    return (Complaint) super.clone();
  }

}
