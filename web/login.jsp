<%-- 
    Document   : registration
    Created on : Nov 28, 2019, 4:43:03 AM
    Author     : WaAd_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="maincss.css">
        <title>Sign Up</title>
    </head>
    <body>
        <form action="Login" method="post">
            <div class="centered">
                <div class="jumbotron">
                    <h1 class="display-2">Login</h1>
                    <p class="text-success lead">Please enter your username & password</p>

                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="user" placeholder="Username">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control"  name="password" placeholder="Password">
                        </div>
                    </div>

                    <!--<div class="form-group">
                        <label for="inputEmail3" class="col-2 control-label">Full name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="name" placeholder="Username">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Username</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="user" placeholder="Username">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control"  name="user" placeholder="Username">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control"  name="password" placeholder="Password">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="exampleSelect1">Favorite color</label>
                        <select class="form-control" id="exampleSelect1">
                            <option>Red</option>
                            <option>Green</option>
                            <option>Blue</option>
                            <option>Pink</option>
                        </select>
                    </div>-->


                    <div class="form-group">
                        <button type="submit" class="btn btn-success btn-lg" >Login </button>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>


