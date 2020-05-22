function showPassword() {
    var showPassword = document.getElementById("form:password").type === "password" ? true : false;
    if (showPassword) {
        document.getElementById("form:password").type = "text";
    } else {
        document.getElementById("form:password").type = "password";
    }
}

