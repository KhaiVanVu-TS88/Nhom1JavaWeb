const contextPath = window.location.pathname.substring(0, window.location.pathname.indexOf('/', 1)) || '';

document.getElementById('addUserBtn').addEventListener('click', function () {
    const email = document.getElementById('exampleFormControlInput1').value.trim();
    const password = document.getElementById('exampleFormControlInput2').value.trim();
    const fullName = document.getElementById('exampleFormControlInput3').value.trim();
    const phone = document.getElementById('exampleFormControlInput4').value.trim();
    const address = document.getElementById('exampleFormControlInput5').value.trim();
    const balance = document.getElementById('exampleFormControlInput7').value.trim();
    const englishLevelEl = document.querySelector('input[name="trinhdo"]:checked');
    const englishLevel = englishLevelEl ? englishLevelEl.value : '';

    // Kiểm tra các trường bắt buộc
    if (!email || !password || !fullName) {
        Swal.fire({
            icon: 'error',
            title: 'Lỗi',
            text: 'Vui lòng điền đầy đủ email, mật khẩu và tên người dùng!'
        });
        return;
    }

    const modalElement = document.getElementById('addholiday');
    const modalInstance = bootstrap.Modal.getInstance(modalElement);

    fetch(`${contextPath}/tablemember`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        },
        body: new URLSearchParams({
            action: 'add',
            email,
            password,
            fullName,
            phone,
            address,
            balance,
            englishLevel
        }).toString()
    })
    .then(response => {
        const contentType = response.headers.get('Content-Type');
        if (!contentType || !contentType.includes('application/json')) {
            return response.text().then(text => {
                throw new Error(`Phản hồi không phải JSON: ${text.substring(0, 100)}...`);
            });
        }
        return response.json();
    })
    .then(data => {
        modalInstance.hide();

        modalElement.addEventListener('hidden.bs.modal', function handler() {
            modalElement.removeEventListener('hidden.bs.modal', handler);

            if (data.success) {
                Swal.fire({
                    icon: 'success',
                    title: 'Thành công',
                    text: data.message,
                    showConfirmButton: false,
                    timer: 1500
                }).then(() => {
                    location.reload();
                });
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Lỗi',
                    text: data.message
                });
            }
        }, { once: true });
    })
    .catch(error => {
        modalInstance.hide();

        modalElement.addEventListener('hidden.bs.modal', function handler() {
            modalElement.removeEventListener('hidden.bs.modal', handler);

            console.error('Lỗi khi gửi yêu cầu:', error);
            Swal.fire({
                icon: 'error',
                title: 'Lỗi',
                text: 'Đã xảy ra lỗi: ' + error.message
            });
        }, { once: true });
    });
});
