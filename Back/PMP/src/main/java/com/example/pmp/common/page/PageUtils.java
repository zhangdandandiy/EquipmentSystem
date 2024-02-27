package com.example.pmp.common.page;

import com.example.pmp.utils.SqlUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页查询工具类
 * 将分页参数和查询条件传入，返回一个包含查询结果和分页信息的对象
 *
 * @author Dandan
 * @date 2023/6/2 14:28
 **/
public class PageUtils {

    /**
     * 在查询之前设置分页参数，再执行查询和设置分页参数之间不能有其他的查询
     *
     * @param pageParam
     * @param queryAction
     * @param <T>
     * @return
     */
    public static <T> Page<T> getPage(PageParam pageParam, QueryAction<T> queryAction) {
        //在查询之前设置分页参数，再执行查询和设置分页参数之间不能有其他的查询。
        //该方法用于设置分页参数对象（含有页码pageName和每页记录数pageSize两个属性）
        PageHelper.startPage(pageParam);
        List<T> list = queryAction.executeQuery();//执行一个查询，获得List集合
        //紧挨在查询之后构造分页信息对象
        PageInfo<T> pageInfo = new PageInfo<>(list);
        Page<T> page = new Page<>();
        page.setCurrentPage(pageInfo.getPageNum());//当前页
        page.setFirstPage(1);//首页
        page.setPrePage(pageInfo.getPrePage());//上一页
        page.setNextPage(pageInfo.getNextPage());//下一页
        page.setLastPage(pageInfo.getPages());//最后一页
        page.setPageSize(pageInfo.getPageSize());//每页最大记录数
        page.setTotalCount(pageInfo.getTotal());//总记录数
        page.setPages(pageInfo.getPages());//总页数
        page.setCurrentSize(pageInfo.getSize());//当前页实际记录数
        page.setList(pageInfo.getList());//当前页数据记录
        return page;
    }

    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        // 驼峰转换
        String orderBy = SqlUtils.escapeOrderBySql(pageDomain.getOrderBy());
        Boolean reasonable = pageDomain.getReasonable();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }

}
