import pandas as pd

def find_employees(df: pd.DataFrame) -> pd.DataFrame:
  v = df.merge(df, how='inner', left_on="managerId", right_on="id")
  v = v[v["salary_x"] > v["salary_y"]][["name_x"]]
  return v.rename(columns={"name_x": "Employee"})