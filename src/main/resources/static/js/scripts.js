let collapsed = false;

function toggleSidebar() {

   let sidenav = document.getElementById("sidenav-container");

   if (collapsed) {
       sidenav.setAttribute("style", "width: 200px;");
   }
   else {
       sidenav.setAttribute("style", "width: 0px;");
   }

   collapsed = !collapsed;
};
