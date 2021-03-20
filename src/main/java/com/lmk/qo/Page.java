package com.lmk.qo;

/**
 * @auth: lmk
 * @Description:
 * @date: 2021/3/11
 */
public class Page {
    //当前页码
    private Integer page=1;

    //起始位置
    private Integer index;

    //显示的页数
    private Integer pageSize = 3;

    //总记录数
    private Integer count;

    //总页数
    private Integer pageTotal;

    public Integer getPageTotal() {
        pageTotal = this.count % this.pageSize == 0 ? this.count / this.pageSize : (this.count / this.pageSize + 1);
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getIndex() {
        return (this.page - 1) * 3;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        //下一页
//        page = this.page >= this.pageTotal ? this.pageTotal : this.page+1;
        this.page = page;
    }
}
