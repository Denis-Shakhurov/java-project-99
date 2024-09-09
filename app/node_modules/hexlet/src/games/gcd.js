import { cons } from 'hexlet-pairs';
import { makeGame } from '..';
import generateNumber from '../utils';

const rule = 'Find the greatest common divisor of given numbers.';

const valueRangeMin = 1;
const valueRangeMax = 100;

const getGcd = (a, b) => {
  if (b === 0) {
    return a;
  }

  return getGcd(b, a % b);
};

const askGcd = () => {
  const num1 = generateNumber(valueRangeMin, valueRangeMax);
  const num2 = generateNumber(valueRangeMin, valueRangeMax);
  const question = `${num1} ${num2}`;
  const answer = String(getGcd(num1, num2));
  const game = cons(question, answer);
  return game;
};

const startGcdGame = () => makeGame(askGcd, rule);

export default startGcdGame;
