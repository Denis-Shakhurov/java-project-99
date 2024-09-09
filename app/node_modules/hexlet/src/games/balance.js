import { cons } from 'hexlet-pairs';
import { makeGame } from '..';
import generateNumber from '../utils';

const rule = 'Balance the given number.';

const valueRangeMin = 10;
const valueRangeMax = 20000;

const getBalancedAsString = (num) => {
  const numeralsList = String(num).split('').map(element => Number(element));
  const length = numeralsList.length;

  const iter = (numerals) => {
    const acc = numerals.sort();
    const max = acc[length - 1];
    const min = acc[0];

    if (max - min > 1) {
      acc[length - 1] -= 1;
      acc[0] += 1;

      return iter(acc);
    }

    return acc.join('');
  };

  return iter(numeralsList);
};

const askBalance = () => {
  const num = generateNumber(valueRangeMin, valueRangeMax);
  const question = `${num}`;
  const answer = getBalancedAsString(num);
  const game = cons(question, answer);
  return game;
};

const startBalanceGame = () => makeGame(askBalance, rule);

export default startBalanceGame;
