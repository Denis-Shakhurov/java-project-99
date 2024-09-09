import { cons } from 'hexlet-pairs';
import { makeGame } from '..';
import generateNumber from '../utils';

const rule = 'What is the result of the expression?';

const valueRangeMin = 1;
const valueRangeMax = 100;

const calculateRandomExpression = (a, b) => {
  switch (generateNumber(1, 3)) {
    case 1:
      return cons(`${a} - ${b}`, `${a - b}`);
    case 2:
      return cons(`${a} + ${b}`, `${a + b}`);
    case 3:
      return cons(`${a} * ${b}`, `${a * b}`);
    default:
      return '';
  }
};

const askCalc = () => {
  const num1 = generateNumber(valueRangeMin, valueRangeMax);
  const num2 = generateNumber(valueRangeMin, valueRangeMax);
  const game = calculateRandomExpression(num1, num2);
  return game;
};

const startCalcGame = () => makeGame(askCalc, rule);

export default startCalcGame;
