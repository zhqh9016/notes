package com.taikang.dic.ltci.model;
/** @author staff修改前后的数据 */
public class StaffDetailDO {
  private StaffComparedDO staffBefore;
  private StaffComparedDO staffAfter;

  public StaffComparedDO getStaffBefore() {
    return staffBefore;
  }

  public void setStaffBefore(StaffComparedDO staffBefore) {
    this.staffBefore = staffBefore;
  }

  public StaffComparedDO getStaffAfter() {
    return staffAfter;
  }

  public void setStaffAfter(StaffComparedDO staffAfter) {
    this.staffAfter = staffAfter;
  }
}
