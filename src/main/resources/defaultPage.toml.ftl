<#-- @ftlvariable name="joomlaData" type="com.thecoderscorner.web.hugojoomla.JoomlaContent" -->
+++
title = "${joomlaData.title}"
description = "${joomlaData.introAsSingleLine}"
tags = [ ${tags} ]
type = "blog"
date = "${joomlaData.createdDateAsText}"
author =  "${joomlaData.author}"
<#if joomlaData.introImage.isImagePresent()>
banner = "${joomlaData.introImage.url}"
</#if>
[menu.main]
name = "${joomlaData.title}"
parent = "${joomlaData.parent}"
+++
<#if joomlaData.bodyImage.isImagePresent() >
    <img class="${joomlaData.bodyImage.htmlClass} titleimg" alt="${joomlaData.bodyImage.alt}" src="${joomlaData.bodyImage.url}"/>
</#if>
${body}