package ${cfg.PagePackage};


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @author ${author}
* @since ${date}
*/
@Data
@ApiModel(value = "分页查询")
public class PageSearchVO<T> {
    @ApiModelProperty("当前页")
    private Integer pageNum;
    @ApiModelProperty("条数")
    private Integer pageSize;
    @ApiModelProperty("查询条件")
    private T data;
    }
<#if superControllerClassPackage??>
</#if>

