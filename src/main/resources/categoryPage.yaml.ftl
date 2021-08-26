<#-- @ftlvariable name="joomlaData" type="com.thecoderscorner.web.hugojoomla.JoomlaContent" -->
---
title: "${joomlaData.title}"
description: "${joomlaData.metadesc}"
date: "${joomlaData.modifiedDateAsText}"
author:  "${joomlaData.author}"
showChildren: true
type: "category"

menu:
  main:
    name: "${joomlaData.title}"
    identifier: "${joomlaData.alias}"
    parent: "${joomlaData.category}"
---

${body}