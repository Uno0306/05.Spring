<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ page session="false" %>

<html>
  <head>
    <meta charset="UTF-8" />
    <title>Department</title>
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <h1>부서 관리</h1>

    <h2>부서 추가(JSON)</h2>
    <form action="/jdbc" method="post" id="formJSON">
      <input
        type="number"
        id="deptno"
        name="deptno"
        placeholder="부서 번호를 입력해주세요"
      />
      <input
        type="text"
        id="dname"
        name="dname"
        placeholder="부서 명을 입력해주세요"
      />
      <input
        type="text"
        id="loc"
        name="loc"
        placeholder="부서 위치를 입력해주세요"
      />
      <input type="submit" onclick="insertJSON()" value="추가" />
    </form>
    <hr />

    <h2>부서 추가(Form)</h2>
    <form action="/jdbc" method="post" id="formForm">
      <input
        type="number"
        id="deptno2"
        name="deptno"
        placeholder="부서 번호를 입력해주세요"
      />
      <input
        type="text"
        id="dname2"
        name="dname"
        placeholder="부서 명을 입력해주세요"
      />
      <input
        type="text"
        id="loc2"
        name="loc"
        placeholder="부서 위치를 입력해주세요"
      />
      <input type="button" onclick="insertForm()" value="추가" />
    </form>
    <hr />

    <h2>부서 수정</h2>
    <form action="/jdbc" method="put" id="update">
      <input
        type="number"
        id="deptno3"
        name="deptno"
        placeholder="수정할 부서 번호를 입력해주세요"
      />
      <input
        type="text"
        id="dname3"
        name="dname"
        placeholder="부서 명을 입력해주세요"
      />
      <input
        type="text"
        id="loc3"
        name="loc"
        placeholder="부서 위치를 입력해주세요"
      />
      <input type="button" onclick="updateJSON()" value="수정" />
    </form>
    <hr />

    <h2>부서 삭제</h2>
    <form action="/jdbc" method="delete" id="delete">
      <input
        type="number"
        id="deptno4"
        name="deptno"
        placeholder="삭제할 부서 번호를 입력해주세요"
      />
      <input type="button" onclick="deleteJSON()" value="삭제" />
    </form>
    <hr />

    <input type="button" onclick="selectAll()" value="모두 검색" />
    <div id="dom"></div>

    <script>
      const deptno = document.getElementById('deptno');
      const dname = document.getElementById('dname');
      const loc = document.getElementById('loc');
      /* json 사용하여 INSERT */
      function insertJSON() {
        const url = 'http://localhost:8080/jdbc/api/deptjson';
        const inputDept = {
          deptno: deptno.value,
          dname: dname.value,
          loc: loc.value,
        };
        const headers = {
          'Content-Type': 'application/json',
        };
        insertAxios(url, inputDept, headers);
      }

      const deptno2 = document.getElementById('deptno2');
      const dname2 = document.getElementById('dname2');
      const loc2 = document.getElementById('loc2');
      /* form 사용하여 INSERT */
      function insertForm() {
        const url = 'http://localhost:8080/jdbc/api/deptform';
        const inputDept =
          'deptno=' +
          deptno2.value +
          '&dname=' +
          dname2.value +
          '&loc=' +
          loc2.value;
        const headers = {
          'Content-Type': 'application/x-www-form-urlencoded',
        };
        insertAxios(url, inputDept, headers);
      }

      /* axios 실행 */
      function insertAxios(url, inputDept, headers) {
        axios.post(url, inputDept, { headers }).catch((error) => {
          console.log(error);
        });
      }

      /* update */
      const deptno3 = document.getElementById('deptno3');
      const dname3 = document.getElementById('dname3');
      const loc3 = document.getElementById('loc3');
      /* json 사용하여 UPDATE */
      function updateJSON() {
        const url = 'http://localhost:8080/jdbc/api/update';
        const updateDept = {
          deptno: deptno3.value,
          dname: dname3.value,
          loc: loc3.value,
        };
        console.log(updateDept);
        const headers = {
          'Content-Type': 'application/json',
        };
        axios
          .put(url, updateDept, { headers })
          .then((response) => {
            console.log(response);
          })
          .catch((error) => {
            console.log(error);
          });
      }

      const deptno4 = document.getElementById('deptno4');
      /* json 사용하여 DELETE */
      function deleteJSON() {
        const url = 'http://localhost:8080/jdbc/api/delete';

        const headers = {
          'Content-Type': 'application/json',
        };
        axios
          .delete(
            url,
            {
              data: {
                deptno: deptno4.value,
              },
            },
            { headers }
          )
          .then((response) => {
            console.log(response);
          })
          .catch((error) => {
            console.log(error);
          });
      }

      /* SELECT all */
      function selectAll() {
        var dom = document.getElementById('dom');
        dom.innerHTML = '';
        const url = 'http://localhost:8080/jdbc/api/depts';
        axios
          .get(url)
          .then((response) => response.data)
          .then((data) => {
            for (var i = 0; i < data.length; i++) {
              var arr = data[i];
              for (da in arr) {
                dom.innerHTML += da + ': ' + arr[da] + ' ';
              }
              dom.innerHTML += '<br/>';
            }
          });
      }
    </script>
  </body>
</html>
