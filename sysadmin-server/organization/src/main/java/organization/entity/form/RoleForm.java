package organization.entity.form;

import com.springboot.cloud.common.core.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import organization.entity.po.Role;

import javax.validation.constraints.NotBlank;

@ApiModel
@Data
public class RoleForm extends BaseForm<Role> {

    @NotBlank(message = "角色编码不能为空")
    @ApiModelProperty(value = "角色编码")
    private String code;

    @NotBlank(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;
}
