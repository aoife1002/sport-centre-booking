document.addEventListener("DOMContentLoaded", function() {
    const resetBtn = document.getElementById("resetBtn");
    const cancelBtn = document.getElementById("cancelBtn");

    resetBtn.addEventListener("click", function() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const confirmPassword = document.getElementById("confirmPassword").value;

        if (password !== confirmPassword) {
            alert("Passwords do not match. Please re-enter.");
            return;
        }

        const account = {
            userName: username,
            password: password
        };

        fetch('/account/update', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(account)
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert("Password reset succeeded!");
                    // 清空表单
                    document.getElementById("username").value = "";
                    document.getElementById("password").value = "";
                    document.getElementById("confirmPassword").value = "";
                } else {
                    alert(data.message);
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });

    cancelBtn.addEventListener("click", function() {
        // 清空表单
        document.getElementById("username").value = "";
        document.getElementById("password").value = "";
        document.getElementById("confirmPassword").value = "";
    });
});
