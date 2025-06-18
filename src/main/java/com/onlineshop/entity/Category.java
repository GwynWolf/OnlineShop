package com.onlineshop.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "parent_id", nullable = false)
    private Integer parentId;

    @Column(nullable = false)
    private String name;

    @Column(name = "name_h1", nullable = false)
    private String nameH1;

    @Column(name = "meta_title", nullable = false)
    private String metaTitle;

    @Column(name = "meta_keywords", nullable = false)
    private String metaKeywords;

    @Column(name = "meta_description", nullable = false)
    private String metaDescription;

    @Column(columnDefinition = "mediumtext")
    private String annotation;

    @Column(columnDefinition = "mediumtext")
    private String description;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Integer position;

    @Column(nullable = false)
    private Boolean visible;

    @Column(name = "show_table_content", nullable = false)
    private Boolean showTableContent;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "level_depth", nullable = false)
    private Integer levelDepth;

    @Column(name = "auto_meta_title", nullable = false)
    private String autoMetaTitle;

    @Column(name = "auto_meta_keywords", nullable = false)
    private String autoMetaKeywords;

    @Column(name = "auto_meta_desc", nullable = false)
    private String autoMetaDesc;

    @Column(name = "auto_description", columnDefinition = "mediumtext")
    private String autoDescription;

    @Column(name = "auto_annotation", columnDefinition = "mediumtext")
    private String autoAnnotation;

    @Column(name = "last_modify", nullable = false)
    private Timestamp lastModify;

    private Timestamp created;

    @Column(name = "auto_h1")
    private String autoH1;

    // --- Геттеры и сеттеры ---

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getParentId() { return parentId; }

    public void setParentId(Integer parentId) { this.parentId = parentId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNameH1() { return nameH1; }

    public void setNameH1(String nameH1) { this.nameH1 = nameH1; }

    public String getMetaTitle() { return metaTitle; }

    public void setMetaTitle(String metaTitle) { this.metaTitle = metaTitle; }

    public String getMetaKeywords() { return metaKeywords; }

    public void setMetaKeywords(String metaKeywords) { this.metaKeywords = metaKeywords; }

    public String getMetaDescription() { return metaDescription; }

    public void setMetaDescription(String metaDescription) { this.metaDescription = metaDescription; }

    public String getAnnotation() { return annotation; }

    public void setAnnotation(String annotation) { this.annotation = annotation; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public Integer getPosition() { return position; }

    public void setPosition(Integer position) { this.position = position; }

    public Boolean getVisible() { return visible; }

    public void setVisible(Boolean visible) { this.visible = visible; }

    public Boolean getShowTableContent() { return showTableContent; }

    public void setShowTableContent(Boolean showTableContent) { this.showTableContent = showTableContent; }

    public String getExternalId() { return externalId; }

    public void setExternalId(String externalId) { this.externalId = externalId; }

    public Integer getLevelDepth() { return levelDepth; }

    public void setLevelDepth(Integer levelDepth) { this.levelDepth = levelDepth; }

    public String getAutoMetaTitle() { return autoMetaTitle; }

    public void setAutoMetaTitle(String autoMetaTitle) { this.autoMetaTitle = autoMetaTitle; }

    public String getAutoMetaKeywords() { return autoMetaKeywords; }

    public void setAutoMetaKeywords(String autoMetaKeywords) { this.autoMetaKeywords = autoMetaKeywords; }

    public String getAutoMetaDesc() { return autoMetaDesc; }

    public void setAutoMetaDesc(String autoMetaDesc) { this.autoMetaDesc = autoMetaDesc; }

    public String getAutoDescription() { return autoDescription; }

    public void setAutoDescription(String autoDescription) { this.autoDescription = autoDescription; }

    public String getAutoAnnotation() { return autoAnnotation; }

    public void setAutoAnnotation(String autoAnnotation) { this.autoAnnotation = autoAnnotation; }

    public Timestamp getLastModify() { return lastModify; }

    public void setLastModify(Timestamp lastModify) { this.lastModify = lastModify; }

    public Timestamp getCreated() { return created; }

    public void setCreated(Timestamp created) { this.created = created; }

    public String getAutoH1() { return autoH1; }

    public void setAutoH1(String autoH1) { this.autoH1 = autoH1; }
}
