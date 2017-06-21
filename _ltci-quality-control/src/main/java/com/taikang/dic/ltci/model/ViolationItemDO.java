package com.taikang.dic.ltci.model;

import java.util.Date;

public class ViolationItemDO {

  private static final long serialVersionUID = 1L;

  private String itemName;

  private String itemType;

  private String id;

  private String complainantType;

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemType() {
    return itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getComplainantType() {
    return complainantType;
  }

  public void setComplainantType(String complainantType) {
    this.complainantType = complainantType;
  }
}
