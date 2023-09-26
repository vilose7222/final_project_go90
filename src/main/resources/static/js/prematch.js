

/** 
document.addEventListener('DOMContentLoaded', function() {
  const tableContainer = document.querySelector('.table-container');
  tableContainer.style.animationDelay = '0';
  tableContainer.style.animationDuration = '1s';
});

document.querySelector('.table-container').addEventListener('click', function() {
  const tableContainer = document.querySelector('.table-container');


  setTimeout(function() {
      tableContainer.style.animationName = 'slide-up';
      tableContainer.style.animationDuration = '2s';
  }, 1000);
});
*/




/**두개의 canvas 를 그린다면...
 두 개의 canvas 요소 가져오기
const canvas1 = document.getElementById('canvas1'); // 첫 번째 canvas
const canvas2 = document.getElementById('canvas2'); // 두 번째 canvas

// 캔버스 컨텍스트 가져오기
const context1 = canvas1.getContext('2d');
const context2 = canvas2.getContext('2d');

// 두 번째 canvas를 첫 번째 canvas 위에 그리기
context1.drawImage(canvas2, 0, 0);

// 첫 번째 canvas를 이미지로 변환
const image = new Image();
image.src = canvas1.toDataURL('image/png'); // 이미지 데이터 URL 생성

// 이미지를 저장하거나 표시할 수 있음
// 예를 들어, 이미지를 다운로드하려면 다음과 같이 사용할 수 있습니다.
const link = document.createElement('a');
link.href = image.src;
link.download = 'combined_image.png'; // 저장할 이미지 파일 이름
link.click();
---------------------------------------------------------------


const canvas1 = document.getElementById('canvas1'); // 첫 번째 canvas
const canvas2 = document.getElementById('canvas2'); // 두 번째 canvas

// 캔버스 컨텍스트 가져오기
const context1 = canvas1.getContext('2d');
const context2 = canvas2.getContext('2d');

// canvas2를 투명하게 설정
canvas2.width = 1200;
canvas2.height = 800;
context2.globalAlpha = 0.5; // 투명도 설정 (0은 완전 투명, 1은 불투명)

// canvas2에 그리기
context2.fillStyle = 'blue'; // 예시로 파란색으로 설정
context2.fillRect(0, 0, canvas2.width, canvas2.height);

// 두 번째 canvas를 첫 번째 canvas 위에 그리기
context1.drawImage(canvas2, 0, 0);
 */