package dev.hongsii.model;

public class Lotto {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public Lotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 중복되었습니다.");
        }

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int match(Lotto other) {
        return lottoNumbers.count(other.lottoNumbers);
    }

    public boolean matchBonus(Lotto other) {
        return bonusNumber.equals(other.bonusNumber);
    }

    @Override
    public String toString() {
        return "numbers : " + lottoNumbers + " / bonusNumber : " + bonusNumber;
    }
}
