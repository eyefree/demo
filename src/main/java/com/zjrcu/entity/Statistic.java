package com.zjrcu.entity;

/**
 * http接口次数统计实体类
 */
public class Statistic {

    private String date;
    private int selectCount;
    private int insertCount;
    private int updateCount;
    private int deleteCount;
    private int insertBatchCount;
    private int updateBatchCount;
    private int deleteBatchCount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSelectCount() {
        return selectCount;
    }

    public void setSelectCount(int selectCount) {
        this.selectCount = selectCount;
    }

    public int getInsertCount() {
        return insertCount;
    }

    public void setInsertCount(int insertCount) {
        this.insertCount = insertCount;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    public int getDeleteCount() {
        return deleteCount;
    }

    public void setDeleteCount(int deleteCount) {
        this.deleteCount = deleteCount;
    }

    public int getInsertBatchCount() {
        return insertBatchCount;
    }

    public void setInsertBatchCount(int insertBatchCount) {
        this.insertBatchCount = insertBatchCount;
    }

    public int getUpdateBatchCount() {
        return updateBatchCount;
    }

    public void setUpdateBatchCount(int updateBatchCount) {
        this.updateBatchCount = updateBatchCount;
    }

    public int getDeleteBatchCount() {
        return deleteBatchCount;
    }

    public void setDeleteBatchCount(int deleteBatchCount) {
        this.deleteBatchCount = deleteBatchCount;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "date='" + date + '\'' +
                ", selectCount=" + selectCount +
                ", insertCount=" + insertCount +
                ", updateCount=" + updateCount +
                ", deleteCount=" + deleteCount +
                ", insertBatchCount=" + insertBatchCount +
                ", updateBatchCount=" + updateBatchCount +
                ", deleteBatchCount=" + deleteBatchCount +
                '}';
    }
}
