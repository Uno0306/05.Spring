<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
session="false" %>

<html>
  <head>
    <title>Home</title>
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <h1>Hello world!!!!!!!!!!!</h1>

    <script>
      /*
           // (JSON) INSERT "/api/deptjson" => deptno : 90, dname : FRONTEND, loc : JEJU
              // INSERT INTO dept(deptno, dname, loc)
              // VALUSE(90, "FRONTEND", "LOC")
         */
      //   const url = 'http://localhost:8080/jdbc/api/deptjson';
      //   const headers = {
      //     'Content-Type': 'application/json',
      //   };
      //   const inputDept = {
      //     deptno: 90,
      //     dname: 'FRONTEND',
      //     loc: 'LOC',
      //   };

      /* // (FormEncoded) INSERT "/api/deptjson" => deptno : 100, dname : TEST, loc : TEST
              // INSERT INTO dept(deptno, dname, loc)
              // VALUSE(100, "TEST", "TEST")
            */
      //   const url = 'http://localhost:8080/jdbc/api/deptform';
      //   const inputDept = 'deptno=100&dname=TEST&loc=TEST';
      //   const headers = {
      //     'Content-Type': 'application/x-www-form-urlencoded',
      //   };

      /* select */
      const url = 'http://localhost:8080/jdbc/api/depts';

      /**/

      //   axios.get(url).then((response) => {
      //     console.log(response);
      //   });

      const dom = document.getElementById('#dom');
      function selectAll() {
        // var arr = new Array();
        var result = ``;
        axios
          .get(url)
          .then((response) => response.data)
          .then((data) => {
            for (var i = 0; i < data.length; i++) {
              //   arr.push(data[i]);
              console.log(data[i]);
              var arr = data[i];
              //   document.write(data[i]);
              for (da in arr) {
                document.write(da + ': ' + arr[da] + ' ');
              }
              document.write('<br/>');
              //   result += `<div>${data[i]}<div><br/>`;
              //   console.log(result);
              //   dom.innerHTML += result;
              //   console.log(dom);
            }
            // $('body').html(result);
            // return dom;
          });
      }
    </script>

    <P> The time on the server is ${serverTime}. </P>

    <input type="button" onclick="selectAll()" value="searchAll" />
    <div id="dom"></div>
  </body>
</html>
