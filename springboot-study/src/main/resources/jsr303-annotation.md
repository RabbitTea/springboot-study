### JSR303数据校验注解

> javax.validation.constraints包

```text
@NotNull(message="名字不能为空")
private String userName;

@Max(value=120, message="年龄最大不能超过120")
private int age;

@Email(message="邮箱格式错误")
private String email;
```

* 空检查
```text
@Null       验证对象是否为null
@NotNull    验证对象是否不为null，无法检查长度为0的字符串
@NotBlank   检查约束字符串是不是null还有被trim的长度是否大于0，只对字符串有效，且会去掉前后空格
@NotEmpty   检查约束元素是否为null或empty
```

* Boolean检查
```text
@AssertTrue    验证Boolean对象是否为true
@AssertFalse   验证Boolean对象是否为false
```

* 长度检查
```text
@Size(min=, max=)     验证对象（Array，Collection，Map，String）长度是否在给定的范围内
@Length(min=, max=)   验证字符串的长度是否在指定范围内
```

* 日期检查
```text
@Past      验证Date和Calendar对象是否在当前时间之前
@Future    验证Date和Calendar对象是否在当前时间之后
@Pattern   验证String对象是否符合正则表达式的规则
```

...

* 我们也可以自定义一些数据校验规则
