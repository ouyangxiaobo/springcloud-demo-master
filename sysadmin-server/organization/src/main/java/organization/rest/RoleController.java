package organization.rest;

import com.springboot.cloud.common.core.entity.vo.Result;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import organization.entity.form.RoleForm;
import organization.entity.param.RoleQueryParam;
import organization.entity.po.Role;
import organization.service.IRoleService;

import javax.validation.Valid;

@RestController
@RequestMapping("/role")
@Api("role")
@Slf4j
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "新增角色", notes = "新增一个角色")
    @ApiImplicitParam(name = "roleForm", value = "新增角色form表单", required = true, dataType = "RoleForm")
    @PostMapping
    public Result add(@Valid @RequestBody RoleForm roleForm) {
        log.debug("name:{}", roleForm);
        Role role = roleForm.toPo(Role.class);
        return Result.success(roleService.add(role));
    }

    @ApiOperation(value = "删除角色", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(paramType = "path", name = "id", value = "角色ID", required = true, dataType = "long")
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable long id) {
        roleService.delete(id);
        return Result.success();
    }

    @ApiOperation(value = "修改角色", notes = "修改指定角色信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "long"),
            @ApiImplicitParam(name = "roleForm", value = "角色实体", required = true, dataType = "RoleForm")
    })
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable long id, @Valid @RequestBody RoleForm roleForm) {
        Role role = roleForm.toPo(Role.class);
        role.setId(id);
        roleService.update(role);
        return Result.success();
    }

    @ApiOperation(value = "获取角色", notes = "获取指定角色信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "角色ID", required = true, dataType = "long")
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable long id) {
        log.debug("get with id:{}", id);
        return Result.success(roleService.get(id));
    }

    @ApiOperation(value = "查询角色", notes = "根据用户id查询用户所拥有的角色信息")
    @ApiImplicitParam(paramType = "path", name = "userId", value = "用户id", required = true, dataType = "long")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping(value = "/user/{userId}")
    public Result query(@PathVariable long userId) {
        log.debug("query with userId:{}", userId);
        return Result.success(roleService.query(userId));
    }

    @ApiOperation(value = "查询角色", notes = "根据条件查询角色信息，简单查询")
    @ApiImplicitParam(paramType = "query", name = "name", value = "角色名称", required = true, dataType = "string")
    @ApiResponses(
            @ApiResponse(code = 200, message = "处理成功", response = Result.class)
    )
    @GetMapping
    public Result query(@RequestParam String name) {
        log.debug("query with name:{}", name);
        RoleQueryParam roleQueryParam = new RoleQueryParam();
        roleQueryParam.setName(name);
        return Result.success(roleService.query(roleQueryParam));
    }
}