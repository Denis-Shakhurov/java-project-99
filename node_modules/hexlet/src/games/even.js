import { cons } from 'hexlet-pairs';
import { makeGame } from '..';
import generateNumber from '../utils';

const rule = 'Answer "yes" if number even otherwise answer "no".';

const valueRangeMin = 1;
const valueRangeMax = 100;

const isEven = num => num % 2 === 0;

const askEven = () => {
  const num = generateNumber(valueRangeMin, valueRangeMax);
  const question = `${num}`;
  const answer = isEven(num) ? 'yes' : 'no';
  const game = cons(question, answer);
  return game;
};

const startEvenGame = () => makeGame(askEven, rule);

export default startEvenGame;
