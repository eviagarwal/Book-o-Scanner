package com.example.android.bookscanner.ModelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

;

public class VolumeInfo {

    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private List<String> authors = null;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("description")
    private String description;
    @SerializedName("industryIdentifiers")
    private List<IndustryIdentifier> industryIdentifiers = null;
    @SerializedName("readingModes")
    private ReadingModes readingModes;
    @SerializedName("pageCount")
    private Integer pageCount;
    @SerializedName("printType")
    private String printType;
    @SerializedName("categories")
    private List<String> categories = null;
    @SerializedName("averageRating")
    private Double averageRating;
    @SerializedName("ratingsCount")
    private Integer ratingsCount;
    @SerializedName("maturityRating")
    private String maturityRating;
    @SerializedName("allowAnonLogging")
    private Boolean allowAnonLogging;
    @SerializedName("contentVersion")
    private String contentVersion;
    @SerializedName("imageLinks")
    private ImageLinks imageLinks;
    @SerializedName("language")
    private String language;
    @SerializedName("previewLink")
    private String previewLink;
    @SerializedName("infoLink")
    private String infoLink;
    @SerializedName("canonicalVolumeLink")
    private String canonicalVolumeLink;

    /**
     * No args constructor for use in serialization
     *
     */
    public VolumeInfo() {
    }

    /**
     *
     * @param pageCount
     * @param averageRating
     * @param readingModes
     * @param infoLink
     * @param printType
     * @param allowAnonLogging
     * @param publisher
     * @param authors
     * @param canonicalVolumeLink
     * @param title
     * @param previewLink
     * @param description
     * @param ratingsCount
     * @param imageLinks
     * @param contentVersion
     * @param categories
     * @param language
     * @param publishedDate
     * @param industryIdentifiers
     * @param maturityRating
     */
    public VolumeInfo(String title, List<String> authors, String publisher, String publishedDate, String description, List<IndustryIdentifier> industryIdentifiers, ReadingModes readingModes, Integer pageCount, String printType, List<String> categories, Double averageRating, Integer ratingsCount, String maturityRating, Boolean allowAnonLogging, String contentVersion, ImageLinks imageLinks, String language, String previewLink, String infoLink, String canonicalVolumeLink) {
        super();
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.industryIdentifiers = industryIdentifiers;
        this.readingModes = readingModes;
        this.pageCount = pageCount;
        this.printType = printType;
        this.categories = categories;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.maturityRating = maturityRating;
        this.allowAnonLogging = allowAnonLogging;
        this.contentVersion = contentVersion;
        this.imageLinks = imageLinks;
        this.language = language;
        this.previewLink = previewLink;
        this.infoLink = infoLink;
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IndustryIdentifier> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers(List<IndustryIdentifier> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public ReadingModes getReadingModes() {
        return readingModes;
    }

    public void setReadingModes(ReadingModes readingModes) {
        this.readingModes = readingModes;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public Boolean getAllowAnonLogging() {
        return allowAnonLogging;
    }

    public void setAllowAnonLogging(Boolean allowAnonLogging) {
        this.allowAnonLogging = allowAnonLogging;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }

    public String getCanonicalVolumeLink() {
        return canonicalVolumeLink;
    }

    public void setCanonicalVolumeLink(String canonicalVolumeLink) {
        this.canonicalVolumeLink = canonicalVolumeLink;
    }

}

