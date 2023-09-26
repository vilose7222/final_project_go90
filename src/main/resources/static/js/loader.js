document.addEventListener('DOMContentLoaded', () => {
	const myteamMenu = document.querySelector('.myteam');
	const loaderContainer = document.getElementById('loader-container');
	const loader = document.getElementById('loader');

	myteamMenu.addEventListener('click', (e) => {
		e.preventDefault();
		// 로딩 화면 보이기
		loaderContainer.style.display = 'block';

		loader.style.animation = 'spin 2s linear infinite';

		// 1.5초 후에 prematch.html로 이동
		setTimeout(() => {
			window.location.href = '/myteam';
		}, 1500);

	});


	window.addEventListener('pageshow', function(e) {
		if (e.persisted) {
			loaderContainer.style.display = 'none'; // 애니메이션 숨기기
			loader.style.animation = ''; // 애니메이션 초기화
		}
	});
});