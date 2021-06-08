package com.marlowe.whell.controller;


import com.github.pagehelper.PageInfo;
import com.marlowe.whell.commons.result.Result;
import com.marlowe.whell.entity.Employee;
import com.marlowe.whell.service.impl.EmployeeServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 员工表 前端控制器
 * </p>
 *
 * @author marlowe
 * @since 2021-06-08
 */
@RestController
@Api(tags = "员工管理控制器")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @ApiOperation(value = "添加员工")
    @PostMapping("add")
    public String addEmployee(@RequestBody Employee employee) {
        boolean b = employeeService.addEmployee(employee);
        if (b) {
            return "添加成功";
        } else {
            return "添加失败";
        }

    }

    /**
     * 根据id删除员工
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除员工")
    @PostMapping("delete/{id}")
    public Result deleteEmployee(@PathVariable int id) {
        boolean delete = employeeService.delete(id);
        if (delete) {
            return Result.ok("删除成功");
        } else {
            return Result.ok("删除失败");
        }
    }

    /**
     * 通过姓名分页查找员工
     *
     * @param name
     * @return
     */
    @ApiOperation(value = "通过姓名分页查找员工")
    @PostMapping("find/{name}/{pageNo}/{pageSize}")
    public Result<List<Employee>> findEmployee(@PathVariable String name, @PathVariable int pageNo, @PathVariable int pageSize) {
        PageInfo<Employee> pageInfo = employeeService.findByName(name, pageNo, pageSize);
        List<Employee> employees = pageInfo.getList();
        return Result.ok(employees);
    }

}
