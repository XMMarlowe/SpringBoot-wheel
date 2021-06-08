package com.marlowe.whell.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.marlowe.whell.entity.Employee;
import com.marlowe.whell.mapper.EmployeeMapper;
import com.marlowe.whell.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author marlowe
 * @since 2021-06-08
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    /**
     * 添加员工
     *
     * @param employee
     * @return
     */
    @Override
    public boolean addEmployee(Employee employee) {
        return employeeMapper.insert(employee) > 0;
    }

    /**
     * 通过id删除员工
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        return employeeMapper.deleteById(id) > 0;
    }

    /**
     * 通过员工姓名分页查询员工
     *
     * @param name
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Employee> findByName(String name, int pageNo, int pageSize) {
        // 设置分页查询参数
        PageHelper.startPage(pageNo, pageSize);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", name);
        List<Employee> employees = employeeMapper.selectList(queryWrapper);
        PageInfo<Employee> pageInfo = new PageInfo(employees);
        return pageInfo;
    }
}
