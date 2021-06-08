package com.marlowe.whell.service;

import com.github.pagehelper.PageInfo;
import com.marlowe.whell.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 员工表 服务类
 * </p>
 *
 * @author marlowe
 * @since 2021-06-08
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 添加员工
     * @param employee
     * @return
     */
    boolean addEmployee(Employee employee);

    /**
     * 通过id删除员工
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 通过员工姓名分页查询员工
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Employee> findByName(String name,int pageNo,int pageSize);

}
