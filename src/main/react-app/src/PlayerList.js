import React, { useState } from 'react';
import './PlayerList.css'; 

const PlayerList = ({ players }) => {
  const [selectedPlayer, setSelectedPlayer] = useState(null);
  const [rating, setRating] = useState(0);
  const [comment, setComment] = useState('');
  const [feedbacks, setFeedbacks] = useState([]);

  const handlePlayerSelect = (player) => {
    setSelectedPlayer(player);
    setRating(0);
    setComment('');
  };

  const handleRatingChange = (value) => {
    setRating(value);
  };

  const handleFeedbackSubmit = () => {
    if (selectedPlayer) {
      const feedback = { player: selectedPlayer, rating, comment };
      setFeedbacks([...feedbacks, feedback]);
      setSelectedPlayer(null);
      setRating(0);
      setComment('');
    }
  };

  return (
    <div>
      <h2>선수 리스트</h2>
      <ul>
        {players.map((player) => (
          <li key={player.id}>
            {player.name}
            <button onClick={() => handlePlayerSelect(player)}>선택</button>
          </li>
        ))}
      </ul>

      {selectedPlayer && (
        <div>
          <h3>선택한 선수: {selectedPlayer.name}</h3>
          <div className="rating">
            {[1, 2, 3, 4, 5].map((value) => (
              <span
                key={value}
                className={`rating-star ${value <= rating ? 'selected' : ''}`}
                onMouseEnter={() => handleRatingChange(value)}
                onMouseLeave={() => handleRatingChange(0)}
                onClick={() => handleRatingChange(value)}
              >
                ⭐
              </span>
            ))}
          </div>
          <br />
          <label>
            코멘트:
            <input
              type="text"
              value={comment}
              onChange={(e) => setComment(e.target.value)}
            />
          </label>
          <br />
          <button onClick={handleFeedbackSubmit}>Feedback 남기기</button>
        </div>
      )}

      <h2>Feedback 리스트</h2>
      <table>
        <thead>
          <tr>
            <th>선수</th>
            <th>별점</th>
            <th>코멘트</th>
          </tr>
        </thead>
        <tbody>
          {feedbacks.map((feedback, index) => (
            <tr key={index}>
              <td>{feedback.player.name}</td>
              <td>{feedback.rating}</td>
              <td>{feedback.comment}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PlayerList;