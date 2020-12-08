package com.guigu.web;

import com.guigu.bean.User;
import com.guigu.service.UserService;
import com.guigu.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @ClassName cn.saytime.web.UserController
 * @Description
 * @date 2017-07-04 22:46:14
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author freestylewill
     * @Description //TODO 根据ID查询用户
     * @Date 17:23 2018/12/24
     * @param id
     * @return com.guigu.utils.JsonResult
     **/

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public JsonResult getUserById2(@PathVariable(value = "id") Integer id) {
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserById(id);
            r.setResult(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return r;
    }

    /**
     * 查询用户列表
     *
     * @return
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserList() {
        JsonResult r = new JsonResult();
        try {
            List<User> users = userService.getUserList();
            r.setResult(users);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add(@RequestBody User user) {
        JsonResult r = new JsonResult();
        try {
            int orderId = userService.add(user);
            if (orderId < 0) {
                r.setResult(orderId);
                r.setStatus("fail");
            } else {
                r.setResult(orderId);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete(@PathVariable(value = "id") Integer id) {
        JsonResult r = new JsonResult();
        try {
            int ret = userService.delete(id);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

//    /**
//     * 根据id修改用户信息
//     *
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<JsonResult> update(@PathVariable("id") Integer id, @RequestBody User user) {
//        JsonResult r = new JsonResult();
//        try {
//            int ret = userService.update(id, user);
//            if (ret < 0) {
//                r.setResult(ret);
//                r.setStatus("fail");
//            } else {
//                r.setResult(ret);
//                r.setStatus("ok");
//            }
//        } catch (Exception e) {
//            r.setResult(e.getClass().getName() + ":" + e.getMessage());
//            r.setStatus("error");
//
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok(r);
//    }

    @RequestMapping("/")
    public String index() {
        System.err.println("########" + new Date());
        return "Hello Docker!"+"#####"+new Date();
    }

}
