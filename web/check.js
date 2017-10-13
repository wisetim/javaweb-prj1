//判断账号密码格式是否正确
function checkForm() {
    var username = document.getElementById('username').value;
    if (username.length <= 0) {
        alert('账号不能为空！');
        return false;
    } else if (username.length >10) {
        alert('账号不能多于10个字符！');
        return false;
    } else {
        var password = document.getElementById('password').value;
        if (password.length <= 0) {
            alert('密码不能为空！');
            return false;
        } else if (password.length > 10) {
            alert('密码不能多于10个字符！');
            return false;
        }
    }
    return true;
}