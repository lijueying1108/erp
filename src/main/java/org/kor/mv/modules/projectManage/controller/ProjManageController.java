package org.kor.mv.modules.projectManage.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("project")
@RequiresAuthentication
public class ProjManageController {

}
