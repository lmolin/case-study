let collapsed = false;

function toggleSidebar() {

   let sidenav = document.getElementById("sidenav-container");
   let body = document.getElementsByClassName("page-body");

   if (collapsed) {
       sidenav.setAttribute("style", "width: 200px;");
       for(i = 0; i < body.length; i++) {
                  body[i].setAttribute("style", "margin-left: 200px;");
                }
   }
   else {
       sidenav.setAttribute("style", "width: 0px;");
       for(i = 0; i < body.length; i++) {
           body[i].setAttribute("style", "margin-left: 0px;");
         }
   }

   collapsed = !collapsed;
};

 var check = function() {
      if (document.getElementById('password').value ==
          document.getElementById('confirm-password').value) {
          document.getElementById('message').style.color = 'green';
          document.getElementById('message').innerHTML = 'Passwords match';
      } else {
      		document.getElementById('message').style.color = 'red';
          document.getElementById('message').innerHTML = 'Passwords do not match';
      }
 }
