$(document).ready(function() {
    // Khởi tạo DataTable với tối ưu hóa cho dữ liệu lớn
    var table = $('#myProjectTable').DataTable({
        responsive: true,
        deferRender: true, 
        pageLength: 10,
        paging: true,
        processing: true,
        columnDefs: [
            { targets: [-1, -3], className: 'dt-body-right' }
        ],
       
        drawCallback: function() {
            // Gắn lại sự kiện sau mỗi lần vẽ bảng
            bindDeleteEvents();
        }
    });

    // Hàm gắn sự kiện xóa
    function bindDeleteEvents() {
        // Sử dụng event delegation để xử lý nút xóa
        $('#myProjectTable tbody').off('click', '.deleterow').on('click', '.deleterow', function(e) {
            e.preventDefault();
            var $row = $(this).closest('tr');
            table
                .row($row)
                .remove()
                .draw(false); // Giữ trang hiện tại
        });
    }

    // Gắn sự kiện ban đầu
    bindDeleteEvents();
});