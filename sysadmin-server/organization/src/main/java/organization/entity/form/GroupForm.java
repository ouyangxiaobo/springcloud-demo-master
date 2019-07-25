package organization.entity.form;

import com.springboot.cloud.common.core.entity.form.BaseForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import organization.entity.po.Group;

import javax.validation.constraints.NotBlank;

@ApiModel
@Data
public class GroupForm extends BaseForm<Group> {

    @NotBlank(message = "用户组父id不能为空")
    @ApiModelProperty(value = "用户组父id")
    private String parentId;

    @NotBlank(message = "用户组名称不能为空")
    @ApiModelProperty(value = "用户组名称")
    private String name;

    @ApiModelProperty(value = "用户组描述")
    private String description;
}
