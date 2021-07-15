package ${package.Controller};

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import org.springframework.web.bind.annotation.*;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
@Api(value = "${table.controllerName}", tags = {"${table.comment!}操作接口"})
public class ${table.controllerName} extends ${superControllerClass}<${table.serviceImplName},${entity}> {
<#else>
@Api(value = "${table.controllerName}", tags = {"${table.comment!}操作接口"})
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${entity}Service ${entity?uncap_first}Service;


    @ApiOperation(value = "${table.comment!}分页查询", notes = "${table.comment!}分页查询")
    @PostMapping("/page")
    public ResultVO<?> pageList(@RequestBody PageSearchVO<${entity}> searchVO) {
        Page<${entity}> page = ${entity?uncap_first}Service.pageList(searchVO.getPageNum(), searchVO.getPageSize(), searchVO.getData());
        return ResultVoUtil.success(page);
    }

    @ApiOperation(value = "添加", notes = "添加")
    @PostMapping("")
    public ResultVO<?> save(@Validated @ApiParam @RequestBody ${entity} ${entity?uncap_first}) {
        boolean b = ${entity?uncap_first}Service.save(${entity?uncap_first});
        return ResultVoUtil.success(b);
    }

    @ApiOperation(value = "修改", notes = "修改")
    @PostMapping(value = "/update")
    public ResultVO<?> update(@Validated @ApiParam @RequestBody ${entity} ${entity?uncap_first}) {
        boolean b = ${entity?uncap_first}Service.saveOrUpdate(${entity?uncap_first});
        return ResultVoUtil.success(b);
    }

    @ApiOperation(value = "删除", notes = "删除")
    @ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true)
    @DeleteMapping("/{id}")
    public ResultVO<?> delete(@Validated @NotBlank(message = "id不能为空") @PathVariable Long id) {
        boolean b = ${entity?uncap_first}Service.removeById(id);
        return ResultVoUtil.success(b);
    }

    @ApiOperation(value = "根据list删除", notes = "根据list删除")
    @PostMapping(value = "/deleteBatch")
    public ResultVO<?> deleteBatch(@Validated @NotEmpty(message = "集合不能为空") @ApiParam @RequestBody List<Long> idList) {
        boolean b = ${entity?uncap_first}Service.removeByIds(idList);
        return ResultVoUtil.success(b);
    }

}
</#if>
