if (typeof jQuery === "undefined") {
	throw new Error("jQuery plugins need to be before this file");
}
$(function() {
	"use strict";
	var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
		return new bootstrap.Tooltip(tooltipTriggerEl)
	})

	// Employees Data
	$(document).ready(function() {
		$.ajax({
			url: 'http://localhost:8080/course/api/nguoidung/giaovien', // Đường dẫn API
			method: 'GET',
			success: function(response) {
				if (response.isSuccess) {
					// Lấy dữ liệu từ trường 'data'
					var data = response.data;

					// Tách labels và series từ dữ liệu
					var labels = data.map(item => {
						if (item.label === 'Basic') return 'Basic';
						if (item.label === 'Intermediate') return 'Intermediate';
						if (item.label === 'Advanced') return 'Advanced';
						return item.label; // Xử lý trường hợp khác (nếu có)
					});
					var series = data.map(item => item.value);

					// Cấu hình biểu đồ với dữ liệu động
					var options = {
						align: 'center',
						chart: {
							height: 250,
							type: 'donut',
							align: 'center',
						},
						labels: labels, // Gán labels từ API
						dataLabels: {
							enabled: false,
						},
						legend: {
							position: 'bottom',
							horizontalAlign: 'center',
							show: true,
						},
						colors: ['var(--chart-color4)', 'var(--chart-color3)', 'var(--chart-color2)'], // Màu tương ứng
						series: series, // Gán series từ API
						responsive: [{
							breakpoint: 480,
							options: {
								chart: {
									width: 200
								},
								legend: {
									position: 'bottom'
								}
							}
						}]
					};

					// Khởi tạo và render biểu đồ
					var chart = new ApexCharts(document.querySelector("#apex-MainCategories"), options);
					chart.render();
				} else {
					console.error('API call failed:', response.description);
				}
			},
			error: function(xhr, status, error) {
				console.error('Error fetching chart data:', error);
			}
		});
	});

	// Employees Analytics
	$(document).ready(function() {
		var options = {
			series: [{
				name: 'Available',
				data: [20, 19, 30, 0, 14, 27, 9, 20],
			}],
			chart: {
				height: 140,
				type: 'line',
				toolbar: {
					show: false,
				}
			},
			grid: {
				show: false,
				xaxis: {
					lines: {
						show: false
					}
				},
				yaxis: {
					lines: {
						show: false
					}
				},
			},
			stroke: {
				width: 4,
				curve: 'smooth',
				colors: ['var(--chart-color2)'],
			},
			xaxis: {
				type: 'datetime',
				categories: ['1/11/2021', '2/11/2021', '3/11/2021', '4/11/2021', '5/11/2021', '6/11/2021', '7/11/2021', '8/11/2021'],
				tickAmount: 10,
				labels: {
					formatter: function(value, timestamp, opts) {
						return opts.dateFormatter(new Date(timestamp), 'dd MMM')
					}
				}
			},
			fill: {
				type: 'gradient',
				gradient: {
					shade: 'dark',
					gradientToColors: ["var(--chart-color3)"],
					shadeIntensity: 1,
					type: 'horizontal',
					opacityFrom: 1,
					opacityTo: 1,
					stops: [0, 100, 100, 100],
				},
			},
			markers: {
				size: 3,
				colors: ["#FFA41B"],
				strokeColors: "#ffffff",
				strokeWidth: 2,
				hover: {
					size: 7,
				}
			},
			yaxis: {
				show: false,
				min: -10,
				max: 50,
			}
		};

		var chart = new ApexCharts(document.querySelector("#apex-emplyoeeAnalytics"), options);
		chart.render();
	});

	// Hr Resource
	$(document).ready(function() {
		$.ajax({
			url: 'http://localhost:8080/course/api/khoahoc/khoahocdaban',
			method: 'GET',
			dataType: 'json',
			success: function(response) {
				if (response.isSuccess) {
					var options = {
						series: response.data, // Use API data directly for series
						chart: {
							type: 'bar',
							height: 300,
							stacked: true,
							toolbar: {
								show: false
							},
							zoom: {
								enabled: true
							}
						},
						colors: ['var(--chart-color1)', 'var(--chart-color2)', 'var(--chart-color3)', 'var(--chart-color4)', 'var(--chart-color5)',
							'var(--chart-color6)', 'var(--chart-color7)', '#000000', '#FF5733', '#33FF57', '#3375FF',
							'#FFC300', '#DAF7A6', '#8E44AD', '#1ABC9C', '#E74C3C', '#F39C12', '#2ECC71', '#3498DB',
							'#7F8C8D', '#C0392B', '#9B59B6', '#16A085'],
						responsive: [{
							breakpoint: 480,
							options: {
								legend: {
									position: 'bottom',
									offsetX: -10,
									offsetY: 0
								}
							}
						}],
						xaxis: {
							categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
						},
						legend: {
							position: 'top',
							horizontalAlign: 'right',
						},
						dataLabels: {
							enabled: false,
						},
						fill: {
							opacity: 1
						}
					};

					var chart = new ApexCharts(document.querySelector("#KhoaHocDaBan"), options);
					chart.render();
				} else {
					console.error('API Error:', response.description);
				}
			},
			error: function(xhr, status, error) {
				console.error('AJAX Error:', status, error);
			}
		});
	});
});