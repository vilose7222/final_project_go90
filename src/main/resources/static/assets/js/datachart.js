/**초기 색상 설정 */
let colors = [
	"rgba(75, 192, 192, 0.5)",
	"rgba(255, 99, 132, 0.5)",
	"rgba(54, 162, 235, 0.5)",
	"rgba(255, 206, 86, 0.5)",
	"rgba(153, 102, 255, 0.5)",
];
let tableRows = document.querySelectorAll(".stats-table tbody tr"); //HTML table 요소 접근

/**첫번째그래프 */
// 초기 데이터
let initialStats = ["득점","도움","태클","세이브"];
let initialScores = [1, 3, 4, 2];
//초기 그래프 생성
let ctx = document.getElementById("scoreChart").getContext("2d");
let myChart = new Chart(ctx, {
	type: "bar",
	data: {
		labels: ["득점", "도움", "태클", "세이브"],
		datasets: [
			{
				data: initialScores,
				backgroundColor: colors,
				borderColor: colors.map(color => color.replace("0.5", "1")),
				borderWidth: 2,
			},
		],
	},
	options: {
		responsive: false,
		scales: {
			y: {
				beginAtZero: true,
			},
		},
	},
});


// 클릭 이벤트 핸들러 등록
tableRows.forEach(function(row, index) {
	row.addEventListener("click", function() {
		// 클릭한 행에서 데이터 가져오기
		let cells = row.getElementsByTagName("td");
		let matchDate = cells[0].textContent;
		let scores = [
			  parseInt(cells[1].textContent),
    parseInt(cells[2].textContent),
    parseInt(cells[3].textContent),
    parseInt(cells[4].textContent),
		];
		 scores = scores.map(score => isNaN(score) ? 0 : score);
		// 그래프 업데이트
		updateChart(matchDate, scores);
	});
});

function updateChart(matchDate, scores) {
	// 기존에 그래프 존재하면 지우기
	myChart.destroy();

	// 새로운 그래프 생성 및 데이터 설정
	myChart = new Chart(ctx, {
		type: "bar",
		data: {
			labels: ["득점", "도움", "태클", "세이브"],
			datasets: [
				{
					data: scores,
					backgroundColor: colors,
					borderColor: colors.map(color => color.replace("0.5", "1")),
					borderWidth: 2,
				},

			],
		},
		options: {
			responsive: true,
			maintainAspectRatio: false,
			scales: {
				y: {
					beginAtZero: true,
				},
			},
			 plugins: {
      legend: {
        display: false, // 상단 라벨 숨김
      },
    },
  
		},
	});
}

// 페이지 로드 시 초기 그래프를 보여주도록 호출
updateChart(initialStats, initialScores);


/*================두번째 그래프================== */


// 초기 데이터
let initialMatchLabels = ["팀 득점", "내 득점", "내 도움", "내 태클", "내 선방"];
let initialPlayerScores = [3, 1, 2, 5, 4]; // 초기 선수 데이터

// Chart.js를 사용하여 초기 두번째 그래프 생성
let ctxMatchBar = document.getElementById("matchScoreChart").getContext("2d");
let datasets = initialMatchLabels.map((label, index) => {
	return {
		label: label,
		data: [initialPlayerScores[index]],
		backgroundColor: colors[index % colors.length],
		borderColor: colors[index % colors.length],
		borderWidth: 2,
	};
});
let matchChart = new Chart(ctxMatchBar, {
	type: "bar",
	data: {
		labels: ["선택한 경기 통계"],
		datasets: datasets,
	},
	options: {
		responsive: true,
		maintainAspectRatio: false,
		scales: {
			y: {
				beginAtZero: true,
			},
		},
	},
});
// 페이지 로드 시 초기 두번째 그래프를 보여주도록 호출
initializeGraph();
let memberIdEl = document.querySelector('input[name="memberId"]');
let memberId = memberIdEl.value;

// fetch로 받아온 정보를 보여주기
async function updateMatchChart(matchId) {
	try {
		const url = `/member/mystats/${matchId}/${memberId}`;
		let response = await fetch(url);
		let data = await response.json();
		// 데이터를 차트 데이터로 변환
		const newData = {
			matchLabels: [data[0].matchDate], // 경기 날짜
			playerScores: [
				{ label: "팀 득점", data: [data[0].teamMatchScore] },
				{ label: "내 득점", data: [data[0].totalGoal] },
				{ label: "내 도움", data: [data[0].totalAssist] },
				{ label: "내 태클", data: [data[0].totalTackle] },
				{ label: "내 선방", data: [data[0].totalSave] },
			],
		};
		// 기존 그래프 제거
		matchChart.destroy();
		// 새로운 그래프 생성 및 데이터 설정
		matchChart = new Chart(ctxMatchBar, {
			type: "bar",
			data: {
				labels: newData.matchLabels,
				datasets: newData.playerScores.map((player, index) => {
					return {
						label: player.label,
						data: player.data,
						backgroundColor: colors[index % colors.length],
						borderColor: colors[index % colors.length],
						borderWidth: 2,
					};
				}),
			},
			options: {
				responsive: true,
				maintainAspectRatio: false,
				scales: {
					y: {
						beginAtZero: true,
					},
				},
			},
		});
	} catch (error) {
		console.error('데이터 불러오기 실패', error);
	}
}
// 예제 데이터를 사용하여 그래프 초기화
function initializeGraph() {
	updateMatchChart(initialMatchLabels, initialPlayerScores);
}
// 페이지 로드 시 초기 두번째 그래프를 보여주도록 호출
initializeGraph();





//총 진행한 경기 수 
const matchCount = document.querySelector('input[name = "matchCount"]').value;
//선수가 참여한 총 경기 수 
const playerMatchCount = document.querySelector('input[name = "playerMatchCount"]').value;

/**세번째 그래프 */

// 총 경기수와 출전 경기수 데이터 
let totalGames = matchCount; 
let participatedGames = playerMatchCount;

// 3번째:파이 차트
let ctxPie = document.getElementById("pieChart").getContext("2d");
let myPieChart = new Chart(ctxPie, {
	type: "pie",
	data: {
		labels: ["총 경기수", "출전 경기수"], // 각 부분의 라벨
		datasets: [
			{
				
				data: [totalGames, participatedGames], // 데이터 값 설정
				backgroundColor: ["rgba(75, 192, 192, 0.5)", "rgba(255, 99, 132, 0.5)"], // 파이 차트 부분의 색상 설정
			},
		],
	},
	options: {
		responsive: true,
		maintainAspectRatio: false,
		tooltips: {
			callbacks: {
				label: function(tooltipItem, data) {
					return data.labels[tooltipItem.index] + ": " + data.datasets[0].data[tooltipItem.index];
				},
			},
		},
	},
});
