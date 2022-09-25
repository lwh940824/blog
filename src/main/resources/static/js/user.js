let index = {
    init: function () {
        document.getElementById('btn-save').addEventListener('click', () => {
            this.save();
        });
    },
    save: function () {
        // alert("User의 save함수 호출됨");
        let data = {
                username: document.getElementById('username').value,
            password: document.getElementById('password').value,
            email: document.getElementById('email').value
        };
        console.log(data);

        let xhr = new XMLHttpRequest();
        xhr.open('POST', '/blog/api/user', true);
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.responseType = 'json';
        xhr.send(JSON.stringify(data));
        xhr.onload = () => {
            if (xhr.status === 200) {
                //success
                alert("회원가입이 완료되었습니다.")
                location.href = "/blog";
            } else {
                //failed
                alert(JSON.stringify(xhr.response));
            }
        }
    }
}

index.init();