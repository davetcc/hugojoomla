<#-- @ftlvariable name="joomlaData" type="com.thecoderscorner.web.hugojoomla.JoomlaContent" -->
---
title: "${joomlaData.title}"
description: "${joomlaData.metadesc}"
date: "${joomlaData.modifiedDateAsText}"
<#if joomlaData.author??>
author:  "${joomlaData.author}"
</#if>
showChildren: true
type: "category"

menu:
  main:
    name: "${joomlaData.title}"
    identifier: "${joomlaData.alias}"
<#if joomlaData.category??>
    parent: "${joomlaData.category}"
</#if>
---

${body}
