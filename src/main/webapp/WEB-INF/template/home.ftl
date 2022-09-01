<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>主页</title>
</head>
<body>
<h1>${user.userName}</h1>
<h1>${flag?c}</h1>
<h1>${flag?string}</h1>
<h1>${flag?string("yes","no")}</h1>
<h1>${createDate?date}</h1>
<h1>${createDate?time}</h1>
<h1>${createDate?datetime}</h1>
<h1>${createDate?string("yyyy/MM/dd HH:mm:ss")}</h1>
<h1>${age}</h1>
<h1>${salary}</h1>
<h1>${avg}</h1>
<h1>${age?c}</h1>
<h1>${salary?string.currency}</h1>
<h1>${avg?string.percent}</h1>
<h1>${avg?string["0.##"]}</h1>
${msg} - ${msg2} <br>
${msg?string} - ${msg2?string} <br>
${msg2?substring(1,4)}
${msg?uncap_first}
${msg2?cap_first}
${msg?lower_case}
${msg?upper_case} <br>
${msg?length} <br>
${msg?starts_with("H")?string} <br>
${msg?ends_with("h")?string} <br>
${msg?index_of("e")} <br>
${msg?trim?length} <br>
${msg?replace("o","a")}<br>
${abc!}
${abc!"默认值"}
${(abc??)?string}


<p>数组和集合-----------------------------------------------------</p>
<p>数组取值:</p>
<#list stars as star>
    ${star}--下标:${star?index}</br>
</#list>

<p>集合取值:</p>
<#-- List操作 -->
<#list cityList as city >
    ${city} <br> </#list>
List的size：${cityList?size} <br> <#-- 倒序输出 -->
<#list cityList?reverse as city >
    ${city} - </#list> <br> <#-- 升序输出 -->
<#list cityList?sort as city >
    ${city} - </#list> <br> <#-- 降序输出 -->
<#list cityList?sort?reverse as city >
    ${city} - </#list>


<p>实体类取值:</p>
<#list userList as users>
    编号:${users.id}&nbsp;
    姓名:${users.name}&nbsp;
    年龄:${users.age}
    </br>
</#list>
<#-- key遍历输出 -->
<#list cityMap?keys as key>
    ${key} -- ${cityMap[key]} <br> </#list> <#-- value遍历输出 -->
<#list cityMap?values as value>
    ${value} | </#list>


<#assign str="hello">
<p>${str}</p>
<#assign num=1 names=["张三","王五","李四"]>
<p>${num} ----${names?join(",")}</p>


<#assign score=80>
<#if score <60>
    <p>你个渣渣</p>
<#elseif score == 60>
    分不在高，及格就行！
<#elseif score gt 60 && score lt 80>
    哎哟不错哦！
<#else>
    你很棒棒哦！
</#if>
<br>
<#-- 判断数据是否存在 -->
<#assign list="">
<#if list??>
    数据存在
<#else>
    数据不存在
</#if>
<br>
<#assign users3 = []> <#-- 当序列没有数据项时，使用默认信息 -->
<#list users3 as user>
    ${user}
<#else>
    当前没有数据！
</#list>


<#-- 定义基本的自定义指令 -->
<#macro address>
    © 1999–2015 The FreeMarker Project. All rights reserved. </#macro> <#-- 使用指令 -->
<@address></@address> <br> <@address></@address>
<hr> <#-- 定义有参数的自定义指令 -->
<#macro queryUserByName uname>
    通过用户名查询用户信息 - ${uname} </#macro> <#-- 使用指令，并传递参数 -->
<@queryUserByName uname="admin"></@queryUserByName> <br> <#-- 定义有多个参数的自定义指令 -->
<#macro queryUserByParams uname uage>
    通过多个餐宿查询用户信息 - ${uname} - ${uage} </#macro> <#-- 使用指令，并传递多个参数 -->
<@queryUserByParams uname="admin" uage=18></@queryUserByParams> <br>
<hr> <#-- 自定义指令中包含内置指令 -->
<#macro cfb>
    <#list 1..9 as i>
        <#list 1..i as j>
            ${j}*${i}=${j*i}&nbsp;
        </#list>
        <br>
    </#list> </#macro> <@cfb></@cfb> <@cfb></@cfb> <#-- 动态数据 -->
<#macro cfb2 num>
    <#list 1..num as i>
        <#list 1..i as j>
            ${j}*${i}=${j*i}&nbsp;
        </#list>
        <br>
    </#list> </#macro> <@cfb2 num=5></@cfb2>

<#macro test>
    这是一段文本！
    <#nested>
    <#nested> </#macro> <@test><h4>这是文本后面的内容！</h4></@test>

<#-- 导入命名空间 -->
<#import "commons.ftl" as common> <#-- 使用命名空间中的指令 -->
<@common.cfb></@common.cfb>
<#include "footer.ftl">


<#assign a1 = 8 a2 = 2 >
${a1} + ${a2} = ${a1 + a2} <br/>
${a1} - ${a2} = ${a1 - a2} <br/>
${a1} * ${a2} = ${a1 * a2} <br/>
${a1} / ${a2} = ${a1 / a2} <br/>
${a1} % ${a2} = ${a1 % a2} <br/>
<!--字符串运算-->


${"hello" + "," + "freemarker"}
</body>
</html>