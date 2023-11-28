//package com.f.javaweb.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.text.MessageFormat;
//
///**
// * @author fzy
// * @date 2023/11/23 21:44
// * 根据创建的Servlet对象的生命周期来分析HttpServlet源码
// */
//public class HelloServlet extends HttpServlet {
//    // 通过无参数构造方法创建对象
//    /*
//    public HelloServlet() {
//    }
//    */
//
//    // 没有提供init方法，那么必然执行父类HttpServlet的init方法
//    // HttpServlet类中没有init方法，会继续执行GenericServlet类中的init方法
//    // 这里的init方法是 init()
//
//    // 没有提供service方法，那么必然执行父类HttpServlet的service方法
//    // 这里的service方法是 service(ServletRequest req, ServletResponse res)
//    //              而不是 service(HttpServletRequest req, HttpServletResponse resp)
//    // 而在HttpServlet的service(ServletRequest req, ServletResponse res)中，结尾会调用service(HttpServletRequest req, HttpServletResponse resp)方法
//    // 下面的这个service就是模板方法，在该方法中定义核心算法骨架，具体的实现步骤延迟到子类中去完成
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 获取请求方式
//        // 注意：request.getMethod()方法获取的是请求方式，可能是七种之一：
//        // GET POST PUT DELETE HEAD OPTIONS TRACE
//        String method = req.getMethod();
//
//        long lastModified;
//
//        // 如果请求方式是GET请求，则执行doGet方法。
//        if (method.equals("GET")) {
//            lastModified = this.getLastModified(req);
//            if (lastModified == -1L) {
//                this.doGet(req, resp);
//            } else {
//                long ifModifiedSince;
//                try {
//                    ifModifiedSince = req.getDateHeader("If-Modified-Since");
//                } catch (IllegalArgumentException var9) {
//                    ifModifiedSince = -1L;
//                }
//
//                if (ifModifiedSince < lastModified / 1000L * 1000L) {
//                    this.maybeSetLastModified(resp, lastModified);
//                    this.doGet(req, resp);
//                } else {
//                    resp.setStatus(304);
//                }
//            }
//        } else if (method.equals("HEAD")) {
//            lastModified = this.getLastModified(req);
//            this.maybeSetLastModified(resp, lastModified);
//            this.doHead(req, resp);
//        } else if (method.equals("POST")) {
//            // 如果请求方式是POST请求，则执行doPost方法。
//            this.doPost(req, resp);
//        } else if (method.equals("PUT")) {
//            this.doPut(req, resp);
//        } else if (method.equals("DELETE")) {
//            this.doDelete(req, resp);
//        } else if (method.equals("OPTIONS")) {
//            this.doOptions(req, resp);
//        } else if (method.equals("TRACE")) {
//            this.doTrace(req, resp);
//        } else {
//            String errMsg = lStrings.getString("http.method_not_implemented");
//            Object[] errArgs = new Object[]{method};
//            errMsg = MessageFormat.format(errMsg, errArgs);
//            resp.sendError(501, errMsg);
//        }
//    }
//
//    /*
//    通过以上源代码分析：
//        假设前端发送的请求是get请求，后端程序员重写的方法是doPost，子类没有实现doGet方法，会继续执行父类的doGet方法，父类的doGet方法会报405错误
//        假设前端发送的请求是post请求，后端程序员重写的方法是doGet
//        会发生什么呢？
//            发生405这样的一个错误。
//            405表示前端的错误，发送的请求方式不对。和服务器不一致。不是服务器需要的请求方式。
//
//        通过以上源代码可以知道：**只要HttpServlet类中的doGet方法或doPost方法执行了，必然405**.
//
//    怎么避免405的错误呢？
//        后端重写了doGet方法，前端一定要发get请求。
//        后端重写了doPost方法，前端一定要发post请求。
//        这样可以避免405错误。
//
//        这种前端到底需要发什么样的请求，其实应该后端说了算。后端让发什么方式，前端就得发什么方式。
//
//    有的人，你会看到为了避免405错误，在Servlet类当中，将doGet和doPost方法都进行了重写。
//    这样，确实可以避免405的发生，但是不建议，405错误还是有用的。该报错的时候就应该让他报错。
//    如果你要是同时重写了doGet和doPost，那还不如你直接重写service方法好了。这样代码还能
//    少写一点。
//    */
//}