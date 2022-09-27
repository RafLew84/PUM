package pl.udu.uwr.pum.verynobleappjava.data.nobelprizeresponse;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class NobelAwardsResponse implements Serializable {
  private Meta meta;

  private Links links;

  private List<NobelPrizes> nobelPrizes;

  public Meta getMeta() {
    return this.meta;
  }

  public void setMeta(Meta meta) {
    this.meta = meta;
  }

  public Links getLinks() {
    return this.links;
  }

  public void setLinks(Links links) {
    this.links = links;
  }

  public List<NobelPrizes> getNobelPrizes() {
    return this.nobelPrizes;
  }

  public void setNobelPrizes(List<NobelPrizes> nobelPrizes) {
    this.nobelPrizes = nobelPrizes;
  }

  public static class Meta implements Serializable {
    private String license;

    private Integer offset;

    private Integer nobelPrizeYear;

    private String terms;

    private Integer limit;

    private Integer count;

    private String disclaimer;

    private Integer yearTo;

    private String nobelPrizeCategory;

    public String getLicense() {
      return this.license;
    }

    public void setLicense(String license) {
      this.license = license;
    }

    public Integer getOffset() {
      return this.offset;
    }

    public void setOffset(Integer offset) {
      this.offset = offset;
    }

    public Integer getNobelPrizeYear() {
      return this.nobelPrizeYear;
    }

    public void setNobelPrizeYear(Integer nobelPrizeYear) {
      this.nobelPrizeYear = nobelPrizeYear;
    }

    public String getTerms() {
      return this.terms;
    }

    public void setTerms(String terms) {
      this.terms = terms;
    }

    public Integer getLimit() {
      return this.limit;
    }

    public void setLimit(Integer limit) {
      this.limit = limit;
    }

    public Integer getCount() {
      return this.count;
    }

    public void setCount(Integer count) {
      this.count = count;
    }

    public String getDisclaimer() {
      return this.disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
      this.disclaimer = disclaimer;
    }

    public Integer getYearTo() {
      return this.yearTo;
    }

    public void setYearTo(Integer yearTo) {
      this.yearTo = yearTo;
    }

    public String getNobelPrizeCategory() {
      return this.nobelPrizeCategory;
    }

    public void setNobelPrizeCategory(String nobelPrizeCategory) {
      this.nobelPrizeCategory = nobelPrizeCategory;
    }
  }

  public static class Links implements Serializable {
    private String last;

    private String self;

    private String first;

    public String getLast() {
      return this.last;
    }

    public void setLast(String last) {
      this.last = last;
    }

    public String getSelf() {
      return this.self;
    }

    public void setSelf(String self) {
      this.self = self;
    }

    public String getFirst() {
      return this.first;
    }

    public void setFirst(String first) {
      this.first = first;
    }
  }

  public static class NobelPrizes implements Serializable {
    private String awardYear;

    private CategoryFullName categoryFullName;

    private Integer prizeAmount;

    private Integer prizeAmountAdjusted;

    private String dateAwarded;

    private List<? extends Links> links;

    private List<Laureates> laureates;

    private CategoryFullName category;

    private Laureates.Motivation topMotivation;

    public String getAwardYear() {
      return this.awardYear;
    }

    public void setAwardYear(String awardYear) {
      this.awardYear = awardYear;
    }

    public CategoryFullName getCategoryFullName() {
      return this.categoryFullName;
    }

    public void setCategoryFullName(CategoryFullName categoryFullName) {
      this.categoryFullName = categoryFullName;
    }

    public Integer getPrizeAmount() {
      return this.prizeAmount;
    }

    public void setPrizeAmount(Integer prizeAmount) {
      this.prizeAmount = prizeAmount;
    }

    public Integer getPrizeAmountAdjusted() {
      return this.prizeAmountAdjusted;
    }

    public void setPrizeAmountAdjusted(Integer prizeAmountAdjusted) {
      this.prizeAmountAdjusted = prizeAmountAdjusted;
    }

    public String getDateAwarded() {
      return this.dateAwarded;
    }

    public void setDateAwarded(String dateAwarded) {
      this.dateAwarded = dateAwarded;
    }

    public List<? extends Links> getLinks() {
      return this.links;
    }

    public void setLinks(List<? extends Links> links) {
      this.links = links;
    }

    public List<Laureates> getLaureates() {
      return this.laureates;
    }

    public void setLaureates(List<Laureates> laureates) {
      this.laureates = laureates;
    }

    public CategoryFullName getCategory() {
      return this.category;
    }

    public void setCategory(CategoryFullName category) {
      this.category = category;
    }

    public Laureates.Motivation getTopMotivation() {
      return this.topMotivation;
    }

    public void setTopMotivation(Laureates.Motivation topMotivation) {
      this.topMotivation = topMotivation;
    }

    public static class CategoryFullName implements Serializable {
      private String no;

      private String se;

      private String en;

      public String getNo() {
        return this.no;
      }

      public void setNo(String no) {
        this.no = no;
      }

      public String getSe() {
        return this.se;
      }

      public void setSe(String se) {
        this.se = se;
      }

      public String getEn() {
        return this.en;
      }

      public void setEn(String en) {
        this.en = en;
      }
    }

    public static class Links implements Serializable {
      private String types;

      private String rel;

      private String action;

      private String href;

      public String getTypes() {
        return this.types;
      }

      public void setTypes(String types) {
        this.types = types;
      }

      public String getRel() {
        return this.rel;
      }

      public void setRel(String rel) {
        this.rel = rel;
      }

      public String getAction() {
        return this.action;
      }

      public void setAction(String action) {
        this.action = action;
      }

      public String getHref() {
        return this.href;
      }

      public void setHref(String href) {
        this.href = href;
      }
    }

    public static class Laureates implements Serializable {
      private String portion;

      private String sortOrder;

      private Motivation motivation;

      private Motivation fullName;

      private List<? extends Links> links;

      private String id;

      private Motivation knownName;

      public String getPortion() {
        return this.portion;
      }

      public void setPortion(String portion) {
        this.portion = portion;
      }

      public String getSortOrder() {
        return this.sortOrder;
      }

      public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
      }

      public Motivation getMotivation() {
        return this.motivation;
      }

      public void setMotivation(Motivation motivation) {
        this.motivation = motivation;
      }

      public Motivation getFullName() {
        return this.fullName;
      }

      public void setFullName(Motivation fullName) {
        this.fullName = fullName;
      }

      public List<? extends Links> getLinks() {
        return this.links;
      }

      public void setLinks(List<? extends Links> links) {
        this.links = links;
      }

      public String getId() {
        return this.id;
      }

      public void setId(String id) {
        this.id = id;
      }

      public Motivation getKnownName() {
        return this.knownName;
      }

      public void setKnownName(Motivation knownName) {
        this.knownName = knownName;
      }

      public static class Motivation implements Serializable {
        private String en;

        public String getEn() {
          return this.en;
        }

        public void setEn(String en) {
          this.en = en;
        }
      }
    }
  }
}
