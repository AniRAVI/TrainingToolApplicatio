<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title></title>
<style type="text/css" media="Screen">
#navigation{
    width: 17%;
    float: left;
    
}
#navigation ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
  width: 200px;
}
#navigation a {
  text-decoration: none;
  display: block;
  padding: 3px 12px 3px 8px;
  background-color: #0099CC;
  color: #fff;
  border: 1px solid #ddd;
}
#navigation a:active {
  padding: 2px 13px 4px 7px;
  background-color: #444;
  color: #0099CC;
  border: 1px solid #333;
}

#navigation li li a {
  text-decoration: none;
  padding: 3px 3px 3px 17px;
  background-color: #999;
  color: #111111;
}
#navigation li li a:active {
  padding: 2px 4px 4px 16px;
  background-color: #888;
  color: #000;
}
</style>
<script type="text/javascript">
function swap(targetId){
  if (document.getElementById){
        target = document.getElementById(targetId);
            if (target.style.display == "none"){
                target.style.display = "";
            } else{
                target.style.display = "none";
            }
                
  }
}
</script>

    <div id="navigation">
        <ul>
            <li>
                <a href="#" onclick="swap('sectionOneLinks');return false;">COURSE</a>
                <ul id="sectionOneLinks" style="display: none;">
               <!--    <li><a href="UploadCourse">UPLOAD COURSE</a></li>
                  <li><a href="CourseController?action=listOfCourse">EDIT COURSE</a></li>
                -->   <li><a href="CourseController?action=launchCourse">LAUNCH COURSE</a></li>
                  
                </ul>
            </li>
            <li>
                <a href="#" onclick="swap('sectionTwoLinks');return false;">ASSESMENTS</a>
                <ul id="sectionTwoLinks" style="display: none;">
                 <!--  <li><a href="#">UPLOAD ASSESMENTS</a></li>
                  <li><a href="#">EDIT ASSESMENTS</a></li>
                  -->  <li><a href="#">VIEW ASSESMENTS</a></li>
                  
                 </ul>
            </li>
            <li>
                <a href="#" onclick="swap('sectionThreeLinks');return false;">USERS</a>
                <ul id="sectionThreeLinks" style="display: none;">
                  <li><a href="UserController?action=listUser">EDIT PROFILE </a></li>
                <!--   <li><a href="UserController?action=manageUserRecord">MANAGE USERS</a></li>
                  <li><a href="UserController?action=deleteUserRecord">DELETE USERS</a></li> -->
                  
                </ul>
            </li>
        </ul>
    </div>
