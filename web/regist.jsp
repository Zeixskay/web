
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户注册</title>
  </head>
  <body>
 <div class="a">

     <span >用户注册</span>
     <form action="/regist" method="post" class="e">
         <p>账号</p>
         <input type="text" placeholder="请输入用户名" name="uname"/>
         <p>密码</p>
         <input type="password" placeholder="请输入密码"  name="upwd"/>
         <br/>
         <input type="submit" id="regist" value="注册"/>
         <p>已有账号，<a href="index.jsp" target="_self" >去登录</a></p>
     </form>
 </div>
  </body>
<script>
    document.getElementById("regist").addEventListener('click',function () {
        alert("注册成功！");
    })
</script>
  <style>

      body{
          background-image:url("img/3.gif");
          background-repeat: no-repeat;
          background-size: cover;
          display: flex;
          justify-content: center;
          align-items: center;
          overflow: hidden;
          min-height: 100vh;
          animation: change 9s linear infinite;
      }
      @keyframes change {
          100%{
              background-image: url("img/3.gif");
          }
          67%{
              background-image: url("img/1.gif");
          }
          33%{
              background-image: url("img/2.gif");
          }
      }
      span{
          text-align: center;
          font-size: 24px;
          display: block;
          margin-top: 30px;
      }
      .a{
          width: 420px;
          background: white;
          position: absolute;
          top: 50%;
          left: 50%;
          border-radius: 10px;
          transform: translate(-50%,-50%);
          z-index: 0;
          overflow: hidden;
          box-shadow: 0px 0px 20px 18px #000  ;
          animation: shadow 5s linear infinite;
      }
      @keyframes shadow {
          100%{
              box-shadow: 0px 0px 20px 18px #000  ;
          }
          50%{
              box-shadow: 0px 0px 20px 18px #eaeaee  ;
          }
          to{
              box-shadow: 0px 0px 20px 18px #505458  ;
          }
      }
      .a::before {
          content: "";

          width: 200%;
          height: 200%;
          background-color: #22292f;
          background-image: conic-gradient(transparent, #66ddf7, transparent 30%);
          position: absolute;
          left: -50%;
          z-index: -2;
          top: -50%;

          animation: rorate 3s linear infinite;
      }
      @keyframes rorate{
          100% {
              transform: rotate(360deg);
          }
      }
      .a::after{
          content: "";
          inset: 1vmin;
          background: #eaeaee;
          position: absolute;
          z-index: -1;
      }

      .e {
          margin: 20px 30px;
          text-align: left;
      }

      .e input[type="text"], .e input[type="password"]{
          width: 100%;
          height: 40px;
          border-radius: 3px;
          border: 1px solid #adadad;
          padding: 0 10px;
          box-sizing: border-box;
      }
      .e input[type="submit"]{
          margin-top: 40px;
          width: 100%;
          height: 40px;
          border-radius: 5px;
          color: white;
          border: 1px solid #adadad;
          background: #505458;
          cursor: pointer;
          letter-spacing: 4px;
          margin-bottom: 40px;
      }


  </style>
</html>
